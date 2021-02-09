import pickle
#import _pickle as cPickle

class Banco:
    def __init__(self, contas):
        self.contas = contas


    def gravarContasArquivo(self, nomeArquivo):
        file = open(nomeArquivo, "wb")
        pickle.dump(self.contas, file)
        file.close()

    def carregarContasArquivo(self, nomeArquivo):
        filehandler = open(nomeArquivo, 'rb')
        contas = pickle.load(filehandler)
        return contas








class Conta:
    def __init__(self, nome, numConta, saldo):
        self.nome = nome
        self.numConta = numConta
        self.saldo = saldo

    def __str__(self):
        return " { nome: %s,  numConta: %s, saldo: %s } " % (self.nome, self.numConta, self.saldo)



c1 = Conta ('joao', '808-777', 30)
c2 = Conta ('maria','000-111', 53)
c3 = Conta ('ana', '123-247', 4430)
c4 = Conta ('jose','213-764', 220)
contas = []
contas.append(c1)
contas.append(c2)
contas.append(c3)
contas.append(c4)

banco = Banco(contas)

banco.gravarContasArquivo("contas.txt")
contas = banco.carregarContasArquivo("contas.txt")

print(contas)

for c in contas:
    print(c.__str__())