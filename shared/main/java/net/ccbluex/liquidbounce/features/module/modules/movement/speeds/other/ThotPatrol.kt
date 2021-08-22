/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other
import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.Speed
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils
class ThotPatrol : SpeedMode("ThotPatrol") {

    override fun onUpdate() {
        if (mc.thePlayer!!.isInWater) return
        if (MovementUtils.isMoving) {
            if (mc.thePlayer!!.onGround) {
                mc.thePlayer!!.jump()
                    MovementUtils.HClip(0.1)
                mc.timer.timerSpeed = 4.50f
            } else {
                mc.thePlayer!!.speedInAir = 0.03f
                MovementUtils.strafe(0.30f)
            }
        }
        if (!mc.thePlayer!!.onGround) {
                if (mc.thePlayer!!.fallDistance < 0.1f) {
                    mc.timer.timerSpeed = 1.24f
                }
                if (mc.thePlayer!!.fallDistance > 0.2f) {
                    mc.timer.timerSpeed = 4.50f
                }
                if (mc.thePlayer!!.fallDistance > 0.6) {
                    mc.timer.timerSpeed = 0.30f
                }
        }
    }

    override fun onMotion() {}
    override fun onMove(event: MoveEvent) {}
    override fun onDisable() {
        mc.thePlayer!!.speedInAir = 0.02f
        mc.timer.timerSpeed = 1f
    }
}