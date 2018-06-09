package ecommerce.harminder.headyecommerceapp.contract

class CategoryContract
{

    interface Presenter {
       fun apiFetchCategories()
    }


    interface View{
        fun initiateFragment()
        fun cancelWithError(error:String)
    }

}