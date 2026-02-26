package gym

class GymCapacity {

    companion object {
        private const val MAX_VISITORS = 10
    }

    var visitors: Int = 0
        private set

    @Synchronized
    fun enter(): Boolean {
        return if (visitors < MAX_VISITORS) {
            visitors++
            true
        } else {
            false
        }
    }
}