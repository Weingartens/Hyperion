# CMAKE generated file: DO NOT EDIT!
# Generated by CMake Version 3.23
cmake_policy(SET CMP0009 NEW)

# IMPL_SOURCES at cpu_features/CMakeLists.txt:68 (file)
file(GLOB NEW_GLOB LIST_DIRECTORIES true "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_*.c")
set(OLD_GLOB
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_aarch64_linux_or_android.c"
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_arm_linux_or_android.c"
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_mips_linux_or_android.c"
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_ppc_linux.c"
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_x86_freebsd.c"
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_x86_linux_or_android.c"
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_x86_macos.c"
  "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/cpu_features/src/impl_x86_windows.c"
  )
if(NOT "${NEW_GLOB}" STREQUAL "${OLD_GLOB}")
  message("-- GLOB mismatch!")
  file(TOUCH_NOCREATE "/home/nick/Documents/Projects/ExoPlayer/extensions/av1/src/main/jni/CMakeFiles/cmake.verify_globs")
endif()
