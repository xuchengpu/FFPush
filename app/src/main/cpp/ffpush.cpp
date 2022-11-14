#include <jni.h>
#include <string>
#include "rtmp.h"

using namespace std;
extern "C"
JNIEXPORT jstring JNICALL
Java_com_xcp_ffpush_MainActivity_stringFromJni(JNIEnv *env, jobject thiz) {
    const char *hello="hello form c++2";
    char version[50];
    //  2.3
    sprintf(version, "librtmp version: %d", RTMP_LibVersion());
    return env->NewStringUTF(version);
}