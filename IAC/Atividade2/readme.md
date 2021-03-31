# Descrição das Pastas

Podemos ver os seguintes arquivos nas pastas:

|Pasta                |Conteúdo                 |
|----------------|-------------------------------|
|Kub|`Arquivos utilizados para criar o EKS via Terraform`            
|minipets-k8s-master          |`Arquivos YML para deployment do Projeto Minipets`            |



# Iniciando Docker com Amazon CLI

 **Iniciando Amazon CLI**

  docker run -it --rm -v ${PWD}:/work -w /work --entrypoint /bin/sh amazon/aws-cli:2.0.43

   **Ferramentas uteis** 

 yum install -y jq gzip nano tar git unzip wget


# Login da conta Amazon
***Configuração realizada dentro do docker***

**aws configure**

AWS Access Key ID [None]: ***seu key***

AWS Secret Access Key [None]:***sua senha***

Default region name: us-east-1

Default output format: json


# Instalando Terraform no Docker

**Download Terraform** 

curl -o /tmp/terraform.zip -LO https://releases.hashicorp.com/terraform/0.13.1/terraform_0.13.1_linux_amd64.zip

unzip /tmp/terraform.zip

chmod +x terraform && mv terraform /usr/local/bin/


***Testar Terraform***

terraform

# Criando o Amazon Kubernetes com Terraform

***Acessar a pasta com os arquivos .tf***

cd kub/

***Iniciar, planejar e aplicar o Terraform***

terraform init

terraform plan

terraform apply


# Deployed aplicação Kubernetes


**Pegar Configurações EKS** 

aws eks update-kubeconfig --name getting-started-eks --region us-east-1

**Instalar kubectl no Docker** 

curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl


chmod +x ./kubectl


mv ./kubectl /usr/local/bin/kubectl


***Voltando para a Raiz para executar os arquivos do MiniPets***

cd ..

***Executando projeto MiniPets***

kubectl apply -f minipets-k8s-master

***Comandos para verificar os serviços***

kubectl get nodes

kubectl get deploy

kubectl get pods

kubectl get svc


***Apagar projeto MiniPets***

kubectl delete -f minipets-k8s-master

# Apagar infraestrutura criada pelo Terraform
cd kub/

terraform destroy
 
