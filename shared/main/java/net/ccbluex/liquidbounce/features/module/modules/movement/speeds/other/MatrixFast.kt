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

class MatrixFast : SpeedMode("MatrixFast") {

    override fun onUpdate() {
        if (mc.thePlayer!!.isInWater) return
        if (MovementUtils.isMoving) {
            mc.gameSettings.keyBindJump.pressed = false
            if (mc.thePlayer!!.onGround) {
                mc.thePlayer!!.jump()
                mc.timer.timerSpeed = 2.35f
                if (mc.thePlayer!!.fallDistance > 0.26) {
                    mc.timer.timerSpeed = 1.055f
                    mc.thePlayer!!.motionY = mc.thePlayer!!.motionY / 1.25
                }
            } else {
                if (mc.thePlayer!!.fallDistance < 0.24) {
                    mc.timer.timerSpeed = 1f
                    mc.thePlayer!!.speedInAir = 0.0203523623253f
                }
            }
        } else {
        //thisisneededtodostuffinthis
        }
    }

    override fun onMotion() {}
    override fun onMove(event: MoveEvent) {}
    override fun onDisable() {
        mc.thePlayer!!.speedInAir = 0.02f
        mc.timer.timerSpeed = 1f
    }
}