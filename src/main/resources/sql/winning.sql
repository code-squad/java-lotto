CREATE TABLE `winning` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `first` int(11) unsigned NOT NULL DEFAULT '0',
  `second` int(11) unsigned NOT NULL DEFAULT '0',
  `third` int(11) unsigned NOT NULL DEFAULT '0',
  `fourth` int(11) unsigned NOT NULL DEFAULT '0',
  `fifth` int(11) unsigned NOT NULL DEFAULT '0',
  `income` int(11) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=euckr;