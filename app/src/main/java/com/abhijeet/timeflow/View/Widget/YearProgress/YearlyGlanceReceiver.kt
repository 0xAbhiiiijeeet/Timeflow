package com.abhijeet.timeflow.View.Widget.YearProgress

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver

class YearProgressGlanceReceiver : GlanceAppWidgetReceiver(){
    override val glanceAppWidget: GlanceAppWidget = YearProgress()
}
