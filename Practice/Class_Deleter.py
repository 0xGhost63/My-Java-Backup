#!/usr/bin/env python3

import os

# Target directory to clean
directory = "/media/sannan/SCNZ/Java"
counter=0

# Recursively delete .class files
for root, dirs, files in os.walk(directory):
    for file in files:
        if file.endswith(".class"):
            file_path = os.path.join(root, file)
            try:
                os.remove(file_path)
                print(f"Deleted: {file_path}")
                counter+=1
            except Exception as e:
                print(f"Failed to delete {file_path}: {e}")

print(f"\n{counter} .class files deleted successfully !!")
