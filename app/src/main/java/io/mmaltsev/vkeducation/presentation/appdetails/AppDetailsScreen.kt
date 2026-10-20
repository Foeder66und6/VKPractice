package io.mmaltsev.vkeducation.presentation.appdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.vkpractice.apps
import io.mmaltsev.vkeducation.R
import io.mmaltsev.vkeducation.domain.appdetails.AppDetails
import kotlinx.coroutines.flow.Flow

@Composable
fun AppDetailsScreen(navOnItemClick: () -> Unit, navOnBackClick: () -> Unit, index: Int = -1) {
    val viewModel = hiltViewModel<AppDetailsViewModel>()
    val state by viewModel.state.collectAsState()
    val events = viewModel.events

    val snackbarHostState = remember { SnackbarHostState() }

    ObserveEvents(
        events = events,
        snackbarHostState = snackbarHostState,
    )

    Scaffold(
        snackbarHost = {
            SnackbarHost(snackbarHostState)
        },
        modifier = Modifier.background(MaterialTheme.colorScheme.surface)
    ) { contentPadding ->
        when (val currentState = state) {
            is AppDetailsState.Loading -> {
                AppDetailsLoading(
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Error -> {
                AppDetailsError(
                    onRefreshClick = { viewModel.getAppDetails() },
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }

            is AppDetailsState.Content -> {
                var cont = currentState
                if (index != -1) {
                    val det = cont.appDetails
                    cont = AppDetailsState.Content(AppDetails(det.id, apps[index].title, det.developer, det.category, det.ageRating, det.size, det.iconUrl, det.screenshotUrlList, apps[index].description, apps[index].iconID), cont.similarApps, cont.descriptionCollapsed)
                }
                AppDetailsContent(
                    content = cont,
                    onBackClick = {
                        // TODO: Открыть предыдущий экран через Jetpack Navigation
                        navOnBackClick()
                    },
                    onShareClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onInstallClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onReadMoreClick = {
                        viewModel.collapseDescription()
                    },
                    onSimilarAppDownloadClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    onDeveloperClick = {
                        viewModel.showUnderDevelopmentMessage()
                    },
                    navOnItemClick = navOnItemClick,
                    modifier = Modifier
                        .fillMaxSize()
                        .safeDrawingPadding()
                        .padding(contentPadding),
                )
            }
        }
    }
}

@Composable
private fun ObserveEvents(
    events: Flow<AppDetailsEvent>,
    snackbarHostState: SnackbarHostState,
) {
    val underDevelopementText = stringResource(R.string.under_development)

    LaunchedEffect(Unit) {
        events.collect { event ->
            when (event) {
                is AppDetailsEvent.UnderDevelopment -> {
                    snackbarHostState.showSnackbar(underDevelopementText)
                }
            }
        }
    }
}