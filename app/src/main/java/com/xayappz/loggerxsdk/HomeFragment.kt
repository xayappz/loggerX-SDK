package com.xayappz.loggerxsdk

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.xayappz.loggerxsdk.databinding.FragmentHomeBinding
import com.xayappz.xaysdk.Library
import com.xayappz.xaysdk.LocationEvent

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSendlog.setOnClickListener {
            val locData = LocationEvent(26.828672f, 75.805634f) //lat,lon required fields.

            Library().setup()// initializing locaX SDK

            Library().log(locData) //calling log fn. from locaX SDK.
            /*   --Api Testing

              Library().onApiCall(true)// mocking success response.
              Library().onApiCall(false)// mocking success response.


            */
            Toast.makeText(activity, R.string.sdk_called, Toast.LENGTH_LONG).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}