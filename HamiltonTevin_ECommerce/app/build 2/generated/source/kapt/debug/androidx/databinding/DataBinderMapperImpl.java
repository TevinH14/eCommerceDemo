package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.example.hamiltontevin_ecommerce.DataBinderMapperImpl());
  }
}
