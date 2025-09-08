#!/usr/bin/env python3

import os

# Target directory to clean
directory = "/media/sannan/SCNZ/Java"

# Recursively delete .class files
for root, dirs, files in os.walk(directory):
    for file in files:
        if file.endswith(".class"):
            file_path = os.path.join(root, file)
            try:
                os.remove(file_path)
                print(f"Deleted: {file_path}")
            except Exception as e:
                print(f"Failed to delete {file_path}: {e}")

print("All .class files deleted successfully!")
