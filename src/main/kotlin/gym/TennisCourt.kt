package gym

class TennisCourt(
    private val gymCapacity: GymCapacity,
    private val gymSafe: GymSafe
) {

    companion object {
        private const val PRICE = 1
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