output "LoadBalance" {
  value = aws_lb.loadbalance.dns_name

}

output "RDS-ENDPOINT" {
  value = aws_db_instance.db-web.endpoint

}

output "RDS-User" {
  value = aws_db_instance.db-web.username

}