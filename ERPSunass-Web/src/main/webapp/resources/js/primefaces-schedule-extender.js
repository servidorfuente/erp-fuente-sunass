function extenderSchedule() {
	this.cfg = $.extend(true, this.cfg, {
		views : {
			month : {
				titleFormat : 'DD/MMMM/YYYY',
				columnFormat : 'dddd',
				displayEventEnd : true,
				timeFormat : '(HH:mm)'
			},
			week : {
				titleFormat : 'DD/MMMM/YYYY',
				columnFormat : 'ddd DD/MM/YYYY',
				timeFormat : '(HH:mm)',
				displayEventEnd : true
			},
			day : {
				titleFormat : 'DD/MMMM/YYYY',
				columnFormat : 'dddd DD/MM/YYYY',
				timeFormat : '(HH:mm)',
				displayEventEnd : true
			}
		},
		axisFormat : 'HH:mm - HH:59',
		firstDay: 1
	});
}