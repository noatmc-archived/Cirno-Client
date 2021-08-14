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

class MatrixOnGround : SpeedMode("WarAC2") {

    override fun onUpdate() {
        if (mc.thePlayer!!.isInWater) return
            if (mc.thePlayer!!.onGround) {
                MovementUtils.HClip(0.1)
                mc.thePlayer!!.jump()
        }
        if (!mc.thePlayer!!.onGround && mc.thePlayer!!.fallDistance < 0.24) {
            mc.timer.timerSpeed = 1f
            mc.thePlayer!!.speedInAir = 0.0202523623253f
        }
        if (mc.thePlayer!!.fallDistance > 0.25) {
            mc.timer.timerSpeed = 1.035f
        }
    }

    override fun onMotion() {}
    override fun onMove(event: MoveEvent) {}
    override fun onDisable() {
        mc.thePlayer!!.speedInAir = 0.02f
        mc.timer.timerSpeed = 1f
    }
}