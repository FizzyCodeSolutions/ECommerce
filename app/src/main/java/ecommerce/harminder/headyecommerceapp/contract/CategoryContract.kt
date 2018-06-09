package ecommerce.harminder.headyecommerceapp.contract

import ecommerce.harminder.headyecommerceapp.room.entities.CategoriesPojo

class CategoryContract {

    interface Presenter {
        fun apiFetchCategories()
    }


    interface View {
        fun initiateFragment(data: CategoriesPojo?)
        fun cancelWithError(error: String)
    }

}