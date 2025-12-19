import os

class FileDiscoveryScanner:
    def __init__(self, start_path):
        self.start_path = start_path

    def scan(self):
        print(f"[*] Scanning files from: {self.start_path}\n")

        counter = 0

        for root, dirs, files in os.walk(self.start_path):
            # Prevent entering .git directory
            if ".git" in dirs:
                dirs.remove(".git")

            for file in files:
                full_path = os.path.join(root, file)
                if(full_path.endswith(".java")):
                    print(full_path)
                    counter += 1


        print(f"\nFound {counter} files!")

    def run(self):
        self.scan()


if __name__ == "__main__":
    scanner = FileDiscoveryScanner("/media/sannan/SCNZ/Java")
    scanner.run()
