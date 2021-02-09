from client import *




class InvertCaseWriter:
    def __init__(self, destino):
        self.destino = destino



    def __writer__(self, entrada):
        file = open(self.destino, "w")
        invertido = entrada.swapcase()
        print(invertido)

        file.write(invertido)
        client(message=invertido)





read = input("Digite a entrada: ")
arq = input("Nome arquivo: ")
obj = InvertCaseWriter(arq)
obj.__writer__(read)

