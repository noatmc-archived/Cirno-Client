package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other

import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils

class Yport3 : SpeedMode("FusionYPort") {
    override fun onMotion() {}
    override fun onUpdate() {}
    override fun onMove(event: MoveEvent) {
            if (mc.thePlayer!!.onGround) {
                event.y = 0.02
            }
        if (!mc.thePlayer!!.onGround) {
            MovementUtils.strafe(MovementUtils.speed * 0.97f)
        }
    }
}