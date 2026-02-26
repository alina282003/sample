package news

import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GetAllNewsUseCaseTest {

    @Test
    fun `all news sources are combined`() = runTest {
        val usecase = GetAllNewsUseCase(NewsRepo())

        val result = usecase.getAllNews()

        assertTrue { result.all { it == FakeNews() } }
        assertEquals(9, result.size)
    }
}