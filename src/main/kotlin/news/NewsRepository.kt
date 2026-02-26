package news

interface NewsRepository {

    suspend fun getSportsNews(): List<News>
    suspend fun getCelebrityNews(): List<News>
}