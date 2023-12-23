package com.barisgungorr.newsappcompose.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.barisgungorr.newsappcompose.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConvertor {

    @TypeConverter
    fun sourceToString(source: Source): String { // amacımız source objesini stringe çevirmek
        return "${source.id},${source.name}"
    }
    @TypeConverter
    fun stringToSource(source: String): Source { // burada da tam tersini yapıyoruz yani stringi source objesine çeviriyoruz
      return source.split(",").let {sourceArray->
          Source(sourceArray[0],sourceArray[1])
      }
    }
// bu sayfada yaptığımız işlem şu: bizim veritabanımızda source objesi yok ama bizim veritabanımızda source objesine ihtiyacımız var
// bu yüzden biz source objesini stringe çevirip veritabanına kaydediyoruz ve veritabanından çekerken de stringi source objesine çeviriyoruz
}