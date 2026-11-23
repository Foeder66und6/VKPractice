package com.example.vkpractice

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.vkpractice.data.APIDataSource
import com.example.vkpractice.data.AppAPI
import com.example.vkpractice.data.AppAPIDTO
import com.example.vkpractice.data.AppDTO
import com.example.vkpractice.data.AppMapper
import com.example.vkpractice.data.AppsRepoImpl
import com.example.vkpractice.data.DetailedAppAPIDTO
import com.example.vkpractice.data.ImageLoader
import com.example.vkpractice.data.SimpleDataSource
import com.example.vkpractice.domain.App
import com.example.vkpractice.domain.DetailedApp
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.Mockito.`when`
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.stub

class RepositoryTests {

    private val exampleAppAPIDTO = AppAPIDTO("id", "name", "description", "category", "url")
    private val exampleAppFromAPI = App("name", "category", "description", R.drawable.running,"id")

    @Test
    fun test_apiGetter_invokation() {
        val apiDataSource: APIDataSource = mock<APIDataSource>()
        val appAPI = mock<AppAPI>()
        val dataSource: SimpleDataSource = mock<SimpleDataSource>()
        val imageLoader: ImageLoader = mock<ImageLoader>()
        val mapper: AppMapper = mock<AppMapper>()
        appAPI.stub({onBlocking({getApps()}).doReturn(listOf<AppAPIDTO>())})
        apiDataSource.stub({onBlocking({api()}).doReturn(appAPI)})
        val repo = AppsRepoImpl(dataSource, apiDataSource, imageLoader, mapper)
        runBlocking(){repo.getApps()}
        runBlocking() {
            verify(apiDataSource).api()

        }

    }

    @Test
    fun test_api_method_invocation() {
        val apiDataSource = mock<APIDataSource>()
        val appAPI = mock<AppAPI>()
        val dataSource = mock<SimpleDataSource>()
        val imageLoader = mock<ImageLoader>()
        val mapper = mock<AppMapper>()
        appAPI.stub({onBlocking({getApps()}).doReturn(listOf<AppAPIDTO>())})
        apiDataSource.stub({onBlocking({api()}).doReturn(appAPI)})
        val repo = AppsRepoImpl(dataSource, apiDataSource, imageLoader, mapper)
        runBlocking() {repo.getApps()}
        runBlocking() {
            verify(appAPI).getApps()
        }
    }

    @Test
    fun test_map_invokation_count() {
        val apiDataSource = mock<APIDataSource>()
        val appAPI = mock<AppAPI>()
        val dataSource = mock<SimpleDataSource>()
        val imageLoader = mock<ImageLoader>()
        val mapper = mock<AppMapper>()
        appAPI.stub({onBlocking({getApps()}).doReturn(List<AppAPIDTO>(3, {exampleAppAPIDTO}))})
        apiDataSource.stub({onBlocking({api()}).doReturn(appAPI)})
        `when`(mapper.fromAPIDTO(exampleAppAPIDTO)).doReturn(exampleAppFromAPI)
        val repo = AppsRepoImpl(dataSource, apiDataSource, imageLoader, mapper)
        runBlocking() {repo.getApps()}
        verify(mapper, times(3)).fromAPIDTO(exampleAppAPIDTO)
    }
/*
    @Test
    fun test_is_getApps_correct() {
        val apiDataSource = mock<APIDataSource>()
        val appAPI = mock<AppAPI>()
        val dataSource = mock<SimpleDataSource>()
        val imageLoader = mock<ImageLoader>()
        appAPI.stub({onBlocking({getApps()}).doReturn(List<AppAPIDTO>(3, {exampleAppAPIDTO}))})
        apiDataSource.stub({onBlocking({api()}).doReturn(appAPI)})
        `when`(mapper.fromAPIDTO(exampleAppAPIDTO)).doReturn(exampleAppFromAPI)
        val repo = AppsRepoImpl(dataSource, apiDataSource, imageLoader, mapper)
        val actual = runBlocking() {repo.getApps()}
        assertEquals(List<App>(3, example{}))////APIDTO exampleAppAPIDTO
    }
*/
    @Test
    fun test_correct_rating_range() {
        val apiDataSource = mock<APIDataSource>()
        val appAPI = mock<AppAPI>()
        val dataSource = mock<SimpleDataSource>()
        val imageLoader = mock<ImageLoader>()
        val mapper = mock<AppMapper>()
        val repo = AppsRepoImpl(dataSource, apiDataSource, imageLoader, mapper)
        val actual = runBlocking() {repo.loadRating("cool_id")}
        assert(0 <= actual && actual <= 100)
    }

    @Test
    fun test_from_api_mapping() {

        val mapper = AppMapper()
        val actual = mapper.fromAPIDTO(exampleAppAPIDTO)
        assertEquals(actual, exampleAppFromAPI)
    }

    @Test
    fun test_from_simple_datasource_mapping() {

        val mapper = AppMapper()
        val actual = mapper.fromDTO(AppDTO("name", "description", "category", 1, 1.0f))
        assertEquals(App("name", "category", "description", 1, "cool_id"), actual)
    }

    @Test
    fun test_to_detailed_app_with_empty_screenshots() {
        val mapper = AppMapper()
        val actual = mapper.toDetailedApp(DetailedAppAPIDTO("id", "name", "developer", "category", 0, 0.0f, "url", listOf<String>(), "description"), BitmapFactory.decodeByteArray(ByteArray(0), 0, 0), listOf<Bitmap>())
        assertEquals(DetailedApp("name", BitmapFactory.decodeByteArray(ByteArray(0), 0, 0), "developer", "category", 0.0f,0, listOf<Bitmap>(), "description"), actual)
    }

}