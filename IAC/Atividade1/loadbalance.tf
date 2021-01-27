resource "aws_lb" "loadbalance" {
  name            = "Terraform-LoadBalance"
  security_groups = [aws_security_group.loadbalance.id]
  subnets         = [aws_subnet.public_a.id, aws_subnet.public_b.id]

  tags = {
    "Name" = "Terraform-LoadBalance"
  }
}

resource "aws_lb_target_group" "tg" {
  name     = "Terraform-LoadBalance"
  port     = 80
  protocol = "HTTP"
  vpc_id   = aws_vpc.main.id

  health_check {
    path              = "/"
    healthy_threshold = 2
  }
}

resource "aws_lb_listener" "lbl" {
  load_balancer_arn = aws_lb.loadbalance.arn
  port              = 80
  protocol          = "HTTP"

  default_action {
    type             = "forward"
    target_group_arn = aws_lb_target_group.tg.arn
  }
}