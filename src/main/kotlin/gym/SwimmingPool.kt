package gym

class SwimmingPool(
    private val gymCapacity: GymCapacity,
    private val gymSafe: GymSafe
) {

    companion object {
        private const val PRICE = 2
    }

    fun enter(money: Int): Boolean {
        return if (money == PRICE && gymCapacity.enter()) {
            gymSafe.save(money)
            true
        } else {
            false
        }
    }
}