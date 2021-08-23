/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other

import net.ccbluex.liquidbounce.LiquidBounce
import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.event.PacketEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.Speed
import net.ccbluex.liquidbounce.ui.client.hud.element.elements.Notification
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils

class OldMatrix : SpeedMode("OldMatrix") {

    override fun onUpdate() {
        if (mc.thePlayer!!.isInWater) return
        if (MovementUtils.isMoving) {
            mc.gameSettings.keyBindJump.pressed = false
            if (mc.thePlayer!!.onGround) {
                mc.thePlayer!!.jump()
                mc.timer.timerSpeed = 2.751f
            } else {
                if (mc.thePlayer!!.fallDistance < 0.24 &&!mc.thePlayer!!.onGround) {
                    LiquidBounce.hud.addNotification(Notification("Slow"))
                    mc.timer.timerSpeed = 1f
                    mc.thePlayer!!.speedInAir = 0.0202523623253f
                }
                if (mc.thePlayer!!.fallDistance > 0.25) {
                    LiquidBounce.hud.addNotification(Notification("Fast"))
                    mc.timer.timerSpeed = 1.05f
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