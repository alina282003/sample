package gym

class GymSafe {

    var savings: Int = 0
        private set

    @Synchronized
    fun save(amount: Int) {
        savings += amount
    }
}