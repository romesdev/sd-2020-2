from client import *

class InvertCaseReader:
    def __init__(self, origem):
        self.origem = origem

    def __reader__(self):
        texto = ""
        file = open(self.origem, "r")
        texto = file.readline()
        print(texto)
        print("Uso do Socket:")
        client(message=texto)



arq = input("Nome arquivo: ")
obj = InvertCaseReader(arq)

obj.__reader__()

