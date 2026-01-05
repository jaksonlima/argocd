

````markdown
# Guia de Configuração: Kind + ArgoCD

Este guia cobre a criação de um cluster local usando Kind e a instalação do ArgoCD.

## 1. Criação do Cluster (Kind)

**Pré-requisitos:** É obrigatória a instalação das ferramentas `kind` e `kubectl` antes de prosseguir.

Execute o comando abaixo para criar um cluster chamado `my-cluster`:

```bash
kind create cluster --name my-cluster
```
````

## 2. Instalação do ArgoCD

Crie o namespace dedicado e aplique o manifesto de instalação oficial:

```bash
kubectl create namespace argocd
kubectl apply -n argocd -f [https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml](https://raw.githubusercontent.com/argoproj/argo-cd/stable/manifests/install.yaml)

```

## 3. Acesso e Credenciais

### Recuperar a Senha Inicial

O ArgoCD gera uma senha inicial aleatória armazenada em uma Secret. Use o comando abaixo para recuperá-la e decodificá-la:

```bash
kubectl get secret argocd-initial-admin-secret -n argocd -o jsonpath="{.data.password}" | base64 -d

```

### Acessar a Interface Web

Para acessar o painel do ArgoCD no seu navegador, faça o redirecionamento de porta (_port-forward_):

```bash
kubectl port-forward svc/argocd-server -n argocd 8080:443

```

> **Nota:** O terminal ficará "preso" rodando este processo. Mantenha-o aberto ou rode em segundo plano.

### Login

Acesse **[https://localhost:8080](https://www.google.com/search?q=https://localhost:8080)** no seu navegador.

- **Usuário:** `admin`
- **Senha:** _(A senha recuperada no passo anterior)_

