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


## Instalando Terraform CLI

**Download Terraform** 

curl -o /tmp/terraform.zip -LO https://releases.hashicorp.com/terraform/0.13.1/terraform_0.13.1_linux_amd64.zip

unzip /tmp/terraform.zip

chmod +x terraform && mv terraform /usr/local/bin/


***Testar Terraform***

terraform

## Terraform Amazon Kubernetes Provider

***Acessar a pasta com os arquivos .tf***

cd kub/

***Iniciar, planejar e aplicar o Terraform***

terraform init

terraform plan

terraform apply


## Deployed aplicação Kubernetes


**Pegar EKS config** 

aws eks update-kubeconfig --name getting-started-eks --region us-east-1

**Instalar kubectl** 

curl -LO https://storage.googleapis.com/kubernetes-release/release/`curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt`/bin/linux/amd64/kubectl


chmod +x ./kubectl


mv ./kubectl /usr/local/bin/kubectl


***Acessar a pasta com os arquivos do Projeto Livraria***

cd ..

***Executando projeto livraria***

kubectl apply -f minipets-k8s-master

***Comandos para verificar os serviços***

kubectl get nodes

kubectl get deploy

kubectl get pods

kubectl get svc


***Apagar projeto livraria***

kubectl delete -f minipets-k8s-master

## Apagar tudo
cd kub/

terraform destroy
 
