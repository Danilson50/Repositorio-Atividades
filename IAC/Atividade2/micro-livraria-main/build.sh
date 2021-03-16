cd services/controller
docker build -t cmendes/livraria-controller .
docker push cmendes/livraria-controller

cd ../inventory
docker build -t cmendes/livraria-inventory .
docker push cmendes/livraria-inventory

cd ../shipping
docker build -t cmendes/livraria-shipping .
docker push cmendes/livraria-shipping

cd ../frontend
docker build -t cmendes/livraria-frontend .
docker push cmendes/livraria-frontend
