

# 代码生成方式：
* java -jar avro-tools-1.9.2.jar compile protocol mail.avpr ../../main/java    
注意：当使用的为rpc时用protocol，若只为实体类时为schema
* 使用说明
```
Usage: [-encoding <outputencoding>] [-string] [-bigDecimal] [-dateTimeLogicalTypeImpl <dateTimeType>] [-templateDir <templateDir>] (schema|protocol) input... outputdir
 input - input files or directories
 outputdir - directory to write generated java
 -encoding <outputencoding> - set the encoding of output file(s)
 -string - use java.lang.String instead of Utf8
 -bigDecimal - use java.math.BigDecimal for decimal type instead of java.nio.ByteBuffer
 -dateTimeLogicalTypeImpl [jsr310|joda] - use either Java 8 native date/time classes (JSR 310)(default) or Joda time classes
 -templateDir - directory with custom Velocity templates
```

