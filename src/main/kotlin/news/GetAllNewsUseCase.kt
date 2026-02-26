package news

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

class GetAllNewsUseCase(
    private val repo: NewsRepository
) {

    suspend fun getAllNews(): List<News> = coroutineScope {
        val sportNews = async { repo.getSportsNews() }
        val celebritiesNews = async { repo.getCelebrityNews() }
        awaitAll(sportNews, celebritiesNews).flatten()
    }
}