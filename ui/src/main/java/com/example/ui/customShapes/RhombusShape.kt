package com.example.ui.customShapes

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.*


//class RhombusShape(private val roundRadius: Float) : Shape {
//    override fun createOutline(
//        size: Size,
//        layoutDirection: LayoutDirection,
//        density: Density
//    ) = Outline.Generic(
//        Path().apply {
//            val angle = PI.toFloat() / 4
//            val width = size.width
//            val height = size.height
//            val halfWidth = width / 2
//            val halfHeight = height / 2
//            val A = moveTo(0f, halfHeight)
//            val B = moveTo(halfWidth, 0f)
//            val C = moveTo(width, halfHeight)
//            val D = moveTo(halfWidth, height)
//
//            val cornerRadius = roundRadius
//
//            val CR = size.width / 2
//            val AR = size.height / 2
//
//            val DAE = atan(CR / AR)
//            val DAQ = PI.toFloat() / 2 - DAE
//            val AD = roundRadius / tan(DAE / 2)
//            val DQ = AD * sin(DAQ)
//            val AQ = AD * cos(DAQ)
//
//            return Outline.Generic(
//                Path().apply {
//                    // move to point D
//                    moveTo(AQ, DQ)
//
//                    // line to point G
//                    lineTo(CR, AR - DQ)
//
//                    // right arc
//                    arcToRad(
//                        Rect(Offset(CR - roundRadius, AR - DQ), 2 * roundRadius, 2 * roundRadius),
//                        -DAQ,
//                        2 * DAQ,
//                        false
//                    )
//
//                    // line to point K
//                    lineTo(CR, AR + DQ)
//
//                    // bottom arc
//                    arcToRad(
//                        Rect(Offset(CR - roundRadius, AR + DQ), 2 * roundRadius, 2 * roundRadius),
//                        -DAQ,
//                        2 * DAQ,
//                        false
//                    )
//
//                    // line to point E
//                    lineTo(AQ, DQ)
//                }
//            )
//        })
//}