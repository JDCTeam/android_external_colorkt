package dev.kdrag0n.colorkt.ucs.polar

import dev.kdrag0n.colorkt.ucs.polar.Lch.Companion.toLab
import dev.kdrag0n.colorkt.ucs.polar.Lch.Companion.toLch
import dev.kdrag0n.colorkt.ucs.lab.Srlab2
import dev.kdrag0n.colorkt.util.ConversionGraph
import dev.kdrag0n.colorkt.util.ConversionProvider

/**
 * Polar (LCh) representation of [dev.kdrag0n.colorkt.ucs.lab.Srlab2].
 *
 * @see dev.kdrag0n.colorkt.ucs.polar.Lch
 */
data class Srlch2(
    override val L: Double,
    override val C: Double,
    override val h: Double,
) : Lch {
    /**
     * Convert this color to the Cartesian (Lab) representation of SRLAB2.
     *
     * @see dev.kdrag0n.colorkt.ucs.lab.Lab
     * @return Color in SRLAB2 representation
     */
    fun toSrlab2(): Srlab2 {
        val (l, a, b) = toLab()
        return Srlab2(l, a, b)
    }

    companion object : ConversionProvider {
        override fun register() {
            ConversionGraph.add<Srlab2, Srlch2> { it.toSrlch2() }
            ConversionGraph.add<Srlch2, Srlab2> { it.toSrlab2() }
        }

        /**
         * Convert this color to the polar (LCh) representation of SRLAB2.
         *
         * @see dev.kdrag0n.colorkt.ucs.polar.Lch
         * @return Color in SRLCh2 representation
         */
        fun Srlab2.toSrlch2(): Srlch2 {
            val (l, c, h) = toLch()
            return Srlch2(l, c, h)
        }
    }
}