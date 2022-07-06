package com.example.challenge

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.challenge.databinding.FragmentDetailsBinding
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var barDateSet : BarDataSet
    private val yValues : ArrayList<BarEntry> = arrayListOf()
    private val dataSets:ArrayList<IBarDataSet> = arrayListOf()
    private lateinit var barData: BarData
    private var name = ""
    private var price = ""
    private var photo = ""


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        if(dialog !=null && dialog?.window !=null){
            dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog?.window?.requestFeature(Window.FEATURE_NO_TITLE)
        }

        return binding.root
    }

    override fun getTheme(): Int = R.style.RoomBottomSheetDialogTheme

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        name = requireArguments().getString("name","")
        price = requireArguments().getString("price","")
        photo = requireArguments().getString("photo","")

        binding.title.text = name
        binding.price.text = price

        Glide.with(requireActivity())
            .load(photo)
            .into(binding.imageView2)

        designChart()

    }

    private fun designChart() {

        yValues.add(BarEntry(0f,10f))
        yValues.add(BarEntry(1f,15f))
        yValues.add(BarEntry(2f,20f))

        barDateSet = BarDataSet(yValues,"")
        barDateSet.setDrawValues(false)
        dataSets.add(barDateSet)
        barData = BarData(dataSets)
        binding.chart.data = barData
        binding.chart.isDragEnabled = true
        binding.chart.setScaleEnabled(false)
        binding.chart.axisLeft.setDrawLabels(true)
        binding.chart.axisLeft.setDrawLimitLinesBehindData(false)
        binding.chart.axisRight.setDrawLimitLinesBehindData(false)
        binding.chart.axisRight.setDrawLabels(false)
        binding.chart.xAxis.setDrawAxisLine(true)
        binding.chart.xAxis.axisLineWidth = 1f
        binding.chart.xAxis.axisLineColor = ContextCompat.getColor(requireActivity(),R.color.black)
        binding.chart.axisLeft.setDrawAxisLine(true)
        binding.chart.axisLeft.axisLineWidth = 1f
        binding.chart.axisLeft.axisLineColor = ContextCompat.getColor(requireActivity(),R.color.black)
        binding.chart.axisRight.setDrawAxisLine(false)
        binding.chart.axisLeft.setDrawGridLines(false)
        binding.chart.axisRight.setDrawGridLines(false)
        binding.chart.xAxis.setDrawGridLines(false)
        binding.chart.xAxis.position = XAxis.XAxisPosition.BOTTOM
        binding.chart.legend.form = Legend.LegendForm.NONE
        binding.chart.description.isEnabled = false
        binding.chart.setPinchZoom(true)
        binding.chart.setTouchEnabled(true)
        binding.chart.setScaleEnabled(true)
        binding.chart.isDoubleTapToZoomEnabled = false
        binding.chart.axisLeft.axisMinimum = 0f
        binding.chart.invalidate()
    }
}

