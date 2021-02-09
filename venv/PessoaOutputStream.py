from Pessoa import *
import sys

class PessoaOutputStream:
    def __init__(self, dados, destino):
        self.dados = dados
        self.destino = destino
        self.size = len(dados)

    def _bytes(self):
        bytes = 0
        for i in self.dados:
            bytes += sys.getsizeof(i)
        return bytes

    def __str__(self):
        message = ''
        for p in self.dados:
            message += p.__str__()

        return message

    def _envio(self):
        f = open("myfile.txt", "w")
        f.write()

