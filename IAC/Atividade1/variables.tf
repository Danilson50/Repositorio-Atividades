variable "region" {
  default = "us-east-1"
}

variable "vpc_cidr" {
  default = "172.20.0.0/16"
}

variable "public_a_cidr" {
  default = "172.20.1.0/24"
}

variable "private_a_cidr" {
  default = "172.20.2.0/23"
}

variable "public_b_cidr" {
  default = "172.20.3.0/24"
}

variable "private_b_cidr" {
  default = "172.20.4.0/23"
}

variable "ami" {
  default = "ami-005b753c07ecef59f"
}

variable "instance_type" {
  default = "t2.micro"
}

variable "key_pair" {
  default = "terraform-manual"
}

/*
variable "enabled_metrics" {
  description = "A list of metrics to collect. The allowed values are GroupMinSize, GroupMaxSize, GroupDesiredCapacity, GroupInServiceInstances, GroupPendingInstances, GroupStandbyInstances, GroupTerminatingInstances, GroupTotalInstances"
  type        = "list"

  default = [
    "GroupMinSize",
    "GroupMaxSize",
    "GroupDesiredCapacity",
    "GroupInServiceInstances",
    "GroupPendingInstances",
    "GroupStandbyInstances",
    "GroupTerminatingInstances",
    "GroupTotalInstances",
  ]
}
*/