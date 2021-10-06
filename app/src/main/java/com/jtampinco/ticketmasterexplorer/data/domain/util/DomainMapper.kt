package com.jtampinco.ticketmasterexplorer.data.domain.util

interface DomainMapper<T, DomainModel> {
    fun mapToDomainModel(model: T): DomainModel
    fun mapToDomainModelList(modelList: List<T>): List<DomainModel>
}
