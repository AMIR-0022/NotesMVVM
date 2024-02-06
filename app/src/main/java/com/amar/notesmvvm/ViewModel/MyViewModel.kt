package com.amar.notesmvvm.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.amar.notesmvvm.Models.DataEntity
import com.amar.notesmvvm.MyDb.PoetDb
import com.amar.notesmvvm.Repository.PoetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel(application: Application) : AndroidViewModel(application) {

//    private val _poetList = MutableLiveData<List<DataEntity>>()
//    val poetList: LiveData<List<DataEntity>> = _poetList
//
//    init {
//        fetchData()
//    }
//
//    private fun fetchData() {
//        _poetList.value = SampleData.poetList
//    }

    private val repository: PoetRepository;
    val allPoet: LiveData<List<DataEntity>>;

    init {
        val dao = PoetDb.getInstance(application).getPoetDao();
        repository = PoetRepository(dao);
        allPoet = repository.allPoet;
    }

    fun insertPoet(dataEntity: DataEntity) = viewModelScope.launch (Dispatchers.IO) {
        repository.insert(dataEntity);
    }

    fun deletePoet(dataEntity: DataEntity) = viewModelScope.launch (Dispatchers.IO) {
        repository.delete(dataEntity);
    }

    fun updatePoet(dataEntity: DataEntity) = viewModelScope.launch (Dispatchers.IO) {
        repository.update(dataEntity);
    }

}