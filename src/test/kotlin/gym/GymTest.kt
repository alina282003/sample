package gym

import org.junit.jupiter.api.Assertions.assertFalse
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class GymTest {

    private lateinit var gymCapacity: GymCapacity
    private lateinit var gymSafe: GymSafe


    @BeforeTest
    fun setup() {
        gymCapacity = GymCapacity()
        gymSafe = GymSafe()
        Gym.swimmingPool = SwimmingPool(gymCapacity, gymSafe)
        Gym.tennisCourt = TennisCourt(gymCapacity, gymSafe)
    }

    @Test
    fun `when price is not enough, capacity is 0 and savings is 0`() {
        val resultSwimmingPool = Gym.enterSwimmingPool(0)
        val resultTennisCourt = Gym.enterTennisCourt(0)

        assertFalse(resultSwimmingPool)
        assertFalse(resultTennisCourt)
        assertEquals(0, gymCapacity.visitors)
        assertEquals(0, gymSafe.savings)
    }

    @Test
    fun `when price is enough, capacity is 2 and savings is 3`() {

        val resultSwimmingPool = Gym.enterSwimmingPool(2)
        val resultTennisCourt = Gym.enterTennisCourt(1)

        assertTrue(resultSwimmingPool)
        assertTrue(resultTennisCourt)
        assertEquals(2, gymCapacity.visitors)
        assertEquals(3, gymSafe.savings)
    }
}