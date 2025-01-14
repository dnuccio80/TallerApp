package com.example.tallerapp.application.ui.models

sealed class Routes (val route:String){
    data object HomeScreen: Routes("home")
    data object WorkListScreen: Routes("workList")
    data object AnnotationsScreen: Routes("annotations")
}