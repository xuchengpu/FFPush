cmake_minimum_required(VERSION 3.18.1)

file(GLOB rtmp_src *.c)

set(CMAKE_C_FLAGS "${CMAKE_C_FLAGS} -DNO_CRYPTO")
add_library( # Sets the name of the library.
             rtmp

             # Sets the library as a shared library.
             STATIC # librtmp.a

             # Provides a relative path to your source file(s).
             ${rtmp_src} )


