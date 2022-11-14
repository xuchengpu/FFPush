
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.18.1)
project("ffpush")

# 引入子目录的CmakeList.txt rmtp静态库
add_subdirectory(librtmp)
# Declares and names the project.
#导入头文件的路径 自动查看头文件 <>
include_directories(librtmp)
# 只要有一个C++文件，就是属于C++ == CXX CMAKE_CXX_FLAGS
set(CMAKE_CXX_FLAGS)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        ffpush

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        ffpush.cpp)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        ffpush
        rtmp
        # Links the target library to the log library
        # included in the NDK.
        ${log-lib}
        )
