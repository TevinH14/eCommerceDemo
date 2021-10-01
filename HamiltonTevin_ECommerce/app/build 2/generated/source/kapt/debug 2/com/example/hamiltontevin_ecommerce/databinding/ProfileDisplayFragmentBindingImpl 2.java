package com.example.hamiltontevin_ecommerce.databinding;
import com.example.hamiltontevin_ecommerce.R;
import com.example.hamiltontevin_ecommerce.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ProfileDisplayFragmentBindingImpl extends ProfileDisplayFragmentBinding implements com.example.hamiltontevin_ecommerce.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView2, 8);
        sViewsWithIds.put(R.id.textView3, 9);
        sViewsWithIds.put(R.id.textView4, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ProfileDisplayFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private ProfileDisplayFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (android.widget.Button) bindings[4]
            , (android.widget.EditText) bindings[6]
            , (android.widget.EditText) bindings[5]
            , (android.widget.EditText) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (android.widget.TextView) bindings[9]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[2]
            , (android.widget.TextView) bindings[1]
            , (android.widget.TextView) bindings[3]
            );
        this.btnEditUser.setTag(null);
        this.etEAddress.setTag(null);
        this.etFullName.setTag(null);
        this.etPNumber.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.tvUserEAddress.setTag(null);
        this.tvUserName.setTag(null);
        this.tvUserPNumber.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.hamiltontevin_ecommerce.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.view == variableId) {
            setView((android.view.View) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setView(@Nullable android.view.View View) {
        this.mView = View;
    }
    public void setViewModel(@Nullable com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelPhoneNumLiveData((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelFullNameLiveData((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelEmailLiveData((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelEditMode((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelPhoneNumLiveData(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelPhoneNumLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelFullNameLiveData(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelFullNameLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelEmailLiveData(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelEmailLiveData, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelEditMode(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelEditMode, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelEditModeGetValue = false;
        java.lang.String viewModelEmailLiveDataGetValue = null;
        java.lang.String viewModelEditModeBtnEditUserAndroidStringSaveBtnEditUserAndroidStringEdit = null;
        java.lang.String viewModelFullNameLiveDataGetValue = null;
        int viewModelEditModeViewVISIBLEViewGONE = 0;
        java.lang.String viewModelPhoneNumLiveDataGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelPhoneNumLiveData = null;
        java.lang.Boolean viewModelEditModeGetValue = null;
        int viewModelEditModeViewGONEViewVISIBLE = 0;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelFullNameLiveData = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelEmailLiveData = null;
        com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel viewModel = mViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelEditMode = null;

        if ((dirtyFlags & 0x6fL) != 0) {


            if ((dirtyFlags & 0x61L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.phoneNumLiveData
                        viewModelPhoneNumLiveData = viewModel.getPhoneNumLiveData();
                    }
                    updateLiveDataRegistration(0, viewModelPhoneNumLiveData);


                    if (viewModelPhoneNumLiveData != null) {
                        // read viewModel.phoneNumLiveData.getValue()
                        viewModelPhoneNumLiveDataGetValue = viewModelPhoneNumLiveData.getValue();
                    }
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.fullNameLiveData
                        viewModelFullNameLiveData = viewModel.getFullNameLiveData();
                    }
                    updateLiveDataRegistration(1, viewModelFullNameLiveData);


                    if (viewModelFullNameLiveData != null) {
                        // read viewModel.fullNameLiveData.getValue()
                        viewModelFullNameLiveDataGetValue = viewModelFullNameLiveData.getValue();
                    }
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.emailLiveData
                        viewModelEmailLiveData = viewModel.getEmailLiveData();
                    }
                    updateLiveDataRegistration(2, viewModelEmailLiveData);


                    if (viewModelEmailLiveData != null) {
                        // read viewModel.emailLiveData.getValue()
                        viewModelEmailLiveDataGetValue = viewModelEmailLiveData.getValue();
                    }
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.editMode
                        viewModelEditMode = viewModel.getEditMode();
                    }
                    updateLiveDataRegistration(3, viewModelEditMode);


                    if (viewModelEditMode != null) {
                        // read viewModel.editMode.getValue()
                        viewModelEditModeGetValue = viewModelEditMode.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelEditModeGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelEditModeGetValue);
                if((dirtyFlags & 0x68L) != 0) {
                    if(androidxDatabindingViewDataBindingSafeUnboxViewModelEditModeGetValue) {
                            dirtyFlags |= 0x100L;
                            dirtyFlags |= 0x400L;
                            dirtyFlags |= 0x1000L;
                    }
                    else {
                            dirtyFlags |= 0x80L;
                            dirtyFlags |= 0x200L;
                            dirtyFlags |= 0x800L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? @android:string/save : @android:string/edit
                    viewModelEditModeBtnEditUserAndroidStringSaveBtnEditUserAndroidStringEdit = ((androidxDatabindingViewDataBindingSafeUnboxViewModelEditModeGetValue) ? (btnEditUser.getResources().getString(R.string.save)) : (btnEditUser.getResources().getString(R.string.edit)));
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? View.VISIBLE : View.GONE
                    viewModelEditModeViewVISIBLEViewGONE = ((androidxDatabindingViewDataBindingSafeUnboxViewModelEditModeGetValue) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? View.GONE : View.VISIBLE
                    viewModelEditModeViewGONEViewVISIBLE = ((androidxDatabindingViewDataBindingSafeUnboxViewModelEditModeGetValue) ? (android.view.View.GONE) : (android.view.View.VISIBLE));
            }
        }
        // batch finished
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.btnEditUser, viewModelEditModeBtnEditUserAndroidStringSaveBtnEditUserAndroidStringEdit);
            this.etEAddress.setVisibility(viewModelEditModeViewVISIBLEViewGONE);
            this.etFullName.setVisibility(viewModelEditModeViewVISIBLEViewGONE);
            this.etPNumber.setVisibility(viewModelEditModeViewVISIBLEViewGONE);
            this.tvUserEAddress.setVisibility(viewModelEditModeViewGONEViewVISIBLE);
            this.tvUserName.setVisibility(viewModelEditModeViewGONEViewVISIBLE);
            this.tvUserPNumber.setVisibility(viewModelEditModeViewGONEViewVISIBLE);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.btnEditUser.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etEAddress, viewModelEmailLiveDataGetValue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvUserEAddress, viewModelEmailLiveDataGetValue);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etFullName, viewModelFullNameLiveDataGetValue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvUserName, viewModelFullNameLiveDataGetValue);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etPNumber, viewModelPhoneNumLiveDataGetValue);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvUserPNumber, viewModelPhoneNumLiveDataGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // viewModel
        com.example.hamiltontevin_ecommerce.viewModel.FragmentsViewModel viewModel = mViewModel;
        // viewModel != null
        boolean viewModelJavaLangObjectNull = false;



        viewModelJavaLangObjectNull = (viewModel) != (null);
        if (viewModelJavaLangObjectNull) {


            viewModel.onButtonClick();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.phoneNumLiveData
        flag 1 (0x2L): viewModel.fullNameLiveData
        flag 2 (0x3L): viewModel.emailLiveData
        flag 3 (0x4L): viewModel.editMode
        flag 4 (0x5L): view
        flag 5 (0x6L): viewModel
        flag 6 (0x7L): null
        flag 7 (0x8L): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? @android:string/save : @android:string/edit
        flag 8 (0x9L): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? @android:string/save : @android:string/edit
        flag 9 (0xaL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? View.VISIBLE : View.GONE
        flag 10 (0xbL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? View.VISIBLE : View.GONE
        flag 11 (0xcL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? View.GONE : View.VISIBLE
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.editMode.getValue()) ? View.GONE : View.VISIBLE
    flag mapping end*/
    //end
}