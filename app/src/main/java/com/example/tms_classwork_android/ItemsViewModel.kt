package com.example.tms_classwork_android

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tms_classwork_android.model.ItemsModel

class ItemsViewModel(private val myParam: MyParam) : ViewModel() {

    private val _items = MutableLiveData<List<ItemsModel>>()//для считывания
    val items: LiveData<List<ItemsModel>> = _items

    private val _msg = MutableLiveData<Int>()
    val msg: LiveData<Int> = _msg

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle


    fun getData(){
        val listItems = listOf<ItemsModel>(
            ItemsModel(R.drawable.android,
                "Android",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.swift,
                "IOS",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.flutter,
                "Flutter",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.pyth,
                "Python",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.cplus,
                "C++",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.c,
                "C",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.ruby,
                "Ruby",
                "23.12.2022"
            ),
            ItemsModel(R.drawable.net,
                ".NET",
                "03.01.2018"
            ),
            ItemsModel(R.drawable.go,
                "Golang",
                "23.12.2030"
            ),
            ItemsModel(R.drawable.php,
                "PHP",
                "23.12.2008"
            ),
            ItemsModel(R.drawable.js,
                "JS",
                "20.09.2006"
            ),
            ItemsModel(R.drawable.fruit,
                "React",
                "23.12.1992"
            )
        )
        _items.value = listItems// записываем все значения в data
    }

    fun imageViewClicked(){
        _msg.value = R.string.image_view
    }

    fun elementClicked(name: String, date: String, imageView: Int){
        _bundle.value = NavigateWithBundle(
            name = name,
            date = date,
            image = imageView
        )
    }
//одноразовое действие занулением бандла
    fun userNavigated(){
        _bundle.value = null
    }

}

data class NavigateWithBundle(
    val image: Int,
    val name: String,
    val date: String,

)

class MyParam(){}