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
class MatrixCustom : SpeedMode("MatrixCustom") {

    override fun onUpdate() {
        val speed = LiquidBounce.moduleManager.getModule(Speed::class.java) as Speed? ?: return
        if (mc.thePlayer!!.isInWater) return
        if (MovementUtils.isMoving) {
            if (mc.thePlayer!!.onGround) {
                mc.thePlayer!!.jump()
                if (speed.CustommatrixHclip.get()) {
                    MovementUtils.HClip(speed.matrixcustomHclipValue.get().toDouble())
                }
                mc.timer.timerSpeed = speed.matrixcustomGroundTimerValue.get()
            } else {
                if (!speed.CustommatrixFallTimerValue.get()) {
                    mc.timer.timerSpeed = speed.matrixcustomAirTimerValue.get()
                }
                mc.thePlayer!!.speedInAir = speed.matrixcustomAirSpeedValue.get()
                if (speed.CustommatrixStrafeValue.get()) {
                    MovementUtils.strafe(speed.matrixcustomStrafeValue.get())
                }
            }
        }
        if (!mc.thePlayer!!.onGround) {
        if (speed.CustommatrixFallTimerValue.get()) {
            if (mc.thePlayer!!.fallDistance < 0.1f && !mc.thePlayer!!.onGround) {
                mc.timer.timerSpeed = speed.customFallTimer1.get()
            }
            if (mc.thePlayer!!.fallDistance > 0.2f) {
                mc.timer.timerSpeed = speed.customFallTimer2.get()
            }
            if (mc.thePlayer!!.fallDistance > 0.6) {
                mc.timer.timerSpeed = speed.customFallTimer3.get()
            }
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