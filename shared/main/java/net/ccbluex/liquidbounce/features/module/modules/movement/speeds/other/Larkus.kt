/*
 * LiquidBounce Hacked Client
 * A free open source mixin-based injection hacked client for Minecraft using Minecraft Forge.
 * https://github.com/CCBlueX/LiquidBounce/
 */
package net.ccbluex.liquidbounce.features.module.modules.movement.speeds.other

import net.ccbluex.liquidbounce.event.MoveEvent
import net.ccbluex.liquidbounce.features.module.modules.movement.Speed
import net.ccbluex.liquidbounce.features.module.modules.movement.speeds.SpeedMode
import net.ccbluex.liquidbounce.utils.MovementUtils
private var hclip1 = false
private var t = 0
private var airMoves = 0
class Larkus : SpeedMode("Larkus") {

    override fun onUpdate() {
        if (mc.thePlayer!!.isInWater) return
        if (MovementUtils.isMoving) {
            mc.gameSettings.keyBindJump.pressed = false
            if (mc.thePlayer!!.onGround) {
                mc.thePlayer!!.jump()
                mc.timer.timerSpeed = 1f
            } else {
                if (mc.thePlayer!!.fallDistance < 0.24 && !mc.thePlayer!!.onGround) {
                    mc.timer.timerSpeed = 1f
                }
                if (mc.thePlayer!!.fallDistance > 0.26 && mc.thePlayer!!.fallDistance < 0.34) {
                    mc.timer.timerSpeed = 1.035f
                }
                if (mc.thePlayer!!.fallDistance > 0.35) {
                    mc.timer.timerSpeed = 1f
                }
                if (t == 1) {
                    if (hclip1) {
                        MovementUtils.HClip(-0.3)
                        hclip1 = false
                        t = 0
                    }
                }
                if (t == 2) {
                    if (!hclip1) {
                        MovementUtils.HClip(0.3)
                        hclip1 = true
                    }
                }
                if (t == 3) {
                    if (hclip1) {
                        MovementUtils.HClip(0.3)
                        hclip1 = false
                    }
                }
                if (t == 4) {
                    if (!hclip1) {
                        MovementUtils.HClip(-0.3)
                        hclip1 = true
                        t = 0
                    }
                }
            }
        } else {
        //thisisneededtodostuffinthis
        }
        t++
    }

    override fun onMotion() {
        if (mc.thePlayer!!.fallDistance < 0.6) {
        if (mc.gameSettings.keyBindForward.isKeyDown && !mc.gameSettings.keyBindJump.isKeyDown) {
            if (mc.thePlayer!!.onGround) {
                airMoves = 0
            } else {
                if (airMoves >= 3) {
                    mc.thePlayer!!.jumpMovementFactor = 0.0275f
                }
                if (airMoves >= 4 && airMoves % 2.toDouble() == 0.0) {
                    mc.thePlayer!!.motionY = -0.3f - 0.009 * Math.random()
                    mc.thePlayer!!.jumpMovementFactor = 0.0238f
                }
                airMoves++
            }
        }
    }
}
    override fun onMove(event: MoveEvent) {}
    override fun onDisable() {
        mc.thePlayer!!.speedInAir = 0.02f
        mc.timer.timerSpeed = 1f
        airMoves = 0
        hclip1 = true
        t = 0
    }
}