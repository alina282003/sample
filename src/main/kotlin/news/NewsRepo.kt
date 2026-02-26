package news

import kotlinx.coroutines.delay
import kotlin.random.Random

class NewsRepo : NewsRepository {

    private suspend fun delayRandom() {
        delay(Random.nextLong(from = 400, until = 2000))
    }

    override suspend fun getSportsNews(): List<News> {
        delayRandom()
        return List(5) { FakeNews() }
    }

    override suspend fun getCelebrityNews(): List<News> {
        delayRandom()
        return List(4) { FakeNews() }
    }
}
