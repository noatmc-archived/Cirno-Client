/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other

import net.ccbluex.liquidbounce.api.minecraft.potion.PotionType
import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils

class Matrix : SpeedMode("Matrix") {
    override fun onUpdate() {
        if (MovementUtils.isMoving) {
            if (mc.thePlayer!!.onGround) {
                mc.thePlayer!!.jump()
                mc.timer.timerSpeed = 4.5f
            } else {
                mc.thePlayer!!.speedInAir = 0.0203f
            }
        }
        if (!mc.thePlayer!!.onGround) {
                if (mc.thePlayer!!.fallDistance < 0.1f) {
                    mc.timer.timerSpeed = 2.28f
                }
                if (mc.thePlayer!!.fallDistance > 0.2f) {
                    mc.timer.timerSpeed = 1.83f
                }
                if (mc.thePlayer!!.fallDistance > 0.6) {
                    mc.timer.timerSpeed = 0.25f
                }
            }
        }
    override fun onMotion() {}
    override fun onMove(event: MoveEvent) {}
}
